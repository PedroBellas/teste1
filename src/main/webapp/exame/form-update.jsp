<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Exames</title>
		<s:head />
	</head>

	<body>
        <form class="d-flex flex-column" action="atualizarExame" method="POST">
        	<s:textfield cssClass="d-flex flex-column" name="exam.id" label="codigo do Exame" readonly="true" />
                
            <s:textfield cssClass="d-flex flex-column" name="exam.name" label="Nome do Exame" />
            
            <s:select key="" list="#{true:'Ativo', false:'Inativo'}" name="exam.active" label="Status" />
            
            <s:textarea cssClass="d-flex flex-column" name="exam.descriptionExam" label="Descrição Principal" />
            
            <s:textarea cssClass="d-flex flex-column" name="exam.descriptionExam1" label="Descrição Secundária" />
            
            <s:submit cssClass="dark-green text-white" value="Atualizar exame" />
        </form>
        
        <br />

        <s:a href="listarExames">Voltar</s:a>
	</body>
</html>