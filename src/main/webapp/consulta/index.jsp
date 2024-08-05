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
		<s:a href="avaliacao">Voltar</s:a>
		
		<s:a href="formularioConsulta">Criar Consulta</s:a>
        
		<table>
			<thead>
				<tr>
					<th>código do exame</th>
					<th>Nome do exame</th>
					<th>código do funcionário</th>
					<th>Nome do funcionário</th>
					<th>Data do exame</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			
			<s:iterator value="appointments" var="appointment">
				<tr>
					<td>
						<s:property value="#appointment.exam.id"/>
					</td>
					<td>
						<s:property value="#appointment.exam.name"/>
					</td>
					<td>
						<s:property value="#appointment.employee.id"/>
					</td>
					<td>
						<s:property value="#appointment.employee.name"/>
					</td>
					<td>
						<s:property value="#appointment.date"/>
					</td>
					<td>
						<s:a href="revisarFormularioConsulta?id=%{#appointment.id}">
							Atualizar
						</s:a>
					</td>
					<td>
						<s:a href="deletarConsulta?id=%{#appointment.id}">
							deletar
						</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</body>
</html>