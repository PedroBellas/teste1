<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Funcionario</title>
		<s:head />
	</head>

	<body>
        <form action="atualizarFuncionario" method="POST">
        	<s:textfield name="employee.id" label="codigo do funcionario" readonly="true" />
                
            <s:textfield name="employee.name" label="Nome do funcionario" />
            
            <s:submit value="Atualizar Funcionario" />
        </form>
	</body>
</html>