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
        <form class="d-flex flex-column" action="atualizarConsulta" method="POST">
            <s:select key="" list="#{true:'Ativo', false:'Inativo'}" name="exam.active" label="Status" />
            
            <s:submit cssClass="dark-green text-white" value="Atualizar Consulta" />
        </form>
        
        <br />

        <s:a href="listarConsultas">Voltar</s:a>
	</body>
</html>