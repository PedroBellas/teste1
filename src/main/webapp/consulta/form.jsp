<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Consulta</title>
		<s:head />
	</head>

	<body>
        <form class="d-flex flex-column" action="criarConsulta" method="POST">
			<s:select listKey="id" listValue="name" list="exams" headerValue="Selecione um exame" name="idExam" value="None" label="Código do exame" />
        	
			<s:select listKey="id" listValue="name" list="employees" headerValue="Selecione um funcionário" name="idEmployee" value="None" label="Código do funcionário" />
        	
			<s:textfield type="date" format="yyyy-MM-dd" name="date" label="Data de realização" />
            
            <s:submit cssClass="dark-green text-white" value="Criar Exame" />
        </form>
        
        <br />

        <s:a href="listarConsultas">Voltar</s:a>
	</body>
</html>