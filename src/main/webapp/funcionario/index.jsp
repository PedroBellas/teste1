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
		<s:a href="avaliacao">Voltar</s:a>
	
		<s:a href="formularioFuncionario">Criar Funcionario</s:a>
		
		<br />

		<table>
			<thead>
				<tr>
					<th>codigo</th>
					<th>Nome</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			
			<s:iterator value="employees" var="employee">
				<tr>
					<td>
						<s:property value="#employee.id"/>
					</td>
					<td>
						<s:property value="#employee.name"/>
					</td>
					<td>
						<s:a href="revisarFormularioFuncionario?id=%{#employee.id}">
							Atualizar
						</s:a>
					</td>
					<td>
						<s:a href="deletarFuncionario?id=%{#employee.id}">
							deletar
						</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>