$(function(){
    var modal = $('#inlineForm');
    var modalErro = $('#danger');
    var botaoSalvar = modal.find('.js-modal-categoria-salvar-btn');
    var form = modal.find('form');
    form.on('submit', function(event){event.preventDefault()});
    var url = form.attr('action');
    var selectTipoCat = $('#tipoCatSelect');
    var inputNome = $('#crNome');
    var inputDescricao = $('#crDescriçao');
    var botaoModal = $('#novoForm');
    var selectValue = 0;
    var selectText = '';

    selectTipoCat.on('change',onBuscarCategoria);

    botaoModal.on('click', onBotaoModalClick);
    modal.on('shown.bs.modal', onModalShow);
    modal.on('hide.bs.modal', onModalClose);
    botaoSalvar.on('click', onBotaoSalvarClick);

    function onBuscarCategoria() {
      selectValue = this.value;
      selectText = $(this).find('option').filter(':selected').text();
      console.log('Value: ',selectValue);
      console.log('Text: ',selectText);
      $.ajax({
    	  url: '/categoria/buscar/categoria',
    	  method: 'POST',
    	  contentType: 'application/json',
    	  data: JSON.stringify({id: selectValue,
    		  nome: selectText}),
    	  error: onErroBuscarCategoria,
    	  success: onBuscarCategoriaConcluido
      });
    }

    function onBuscarCategoriaConcluido(resultado){
    	var selectCatLanc = $('#catLancSelect');
    	selectCatLanc.find('option:not(:first)').remove();

    	for (var i = 0; i < resultado.length; i ++ ){
            console.log(resultado[i].nome);
            selectCatLanc.append('<option value='+resultado[i].id+'>'+resultado[i].nome+'</option>');
        }
    }

    function onErroBuscarCategoria(obj){
    	console.log('Mensagem erro: ',obj);
    }

    function onBotaoModalClick(){
        if(selectValue == 0){
            modalErro.modal('show');
        }else{
            modal.modal('show');
        }
    }


    function onModalShow(){
        inputNome.focus();
    }

    function onModalClose(){
        inputNome.val('');
        inputDescricao.val('');
    }

    function onBotaoSalvarClick(){
        var nome = inputNome.val().trim();
        var descricao = inputDescricao.val().trim();
        var tipoCategoria = {id: selectValue,nome: selectText}
        $.ajax({
            url: url,
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify({nome: nome,
                descricao: descricao,
                tipoCategoria: tipoCategoria}),
            error: onErroSalvando,
            success: onCategoriaSalvo
        });
    }

    function onCategoriaSalvo(categoria){
        var selectCatLanc = $('#catLancSelect');
        selectCatLanc.append('<option value='+categoria.id+'>'+categoria.nome+'</option>');
        selectCatLanc.val(categoria.id);
        modal.modal('hide');
    }

    function onErroSalvando(obj){
        var mensagemErro = obj.responseTest;
        console.log('Erro: '+mensagemErro);
    }
});