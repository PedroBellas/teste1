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
        <form class="d-flex flex-column" action="criarExame" method="POST">
            <s:textfield cssClass="d-flex flex-column" name="name" label="Nome do Exame" />
            
            <s:textarea cssClass="d-flex flex-column" name="descriptionExam" label="Descrição Principal" />
            
            <s:textarea cssClass="d-flex flex-column" name="descriptionExam1" label="Descrição Secundária" />
            
            <s:submit cssClass="dark-green text-white" value="Criar Exame" />
        </form>
        
        <br />

        <s:a href="listarExames">Voltar</s:a>
	</body>
</html>