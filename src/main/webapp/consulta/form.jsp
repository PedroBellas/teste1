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
			<s:select listKey="id" listValue="name" list="exams" headerValue="Selecione um exame" name="idExam" label="Código do exame" />
        	
			<s:select listKey="id" listValue="name" list="employees" headerValue="Selecione um funcionário" name="idEmployee" label="Código do funcionário" />
        	
			<s:textfield type="date" format="yyyy-MM-dd" name="date" label="Data da consulta" />
            
            <s:submit cssClass="dark-green text-white" value="Criar Consulta" />
        </form>
        
        <br />

        <s:a href="listarConsultas">Voltar</s:a>
	</body>
</html>