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
		<s:a href="avaliacao">Voltar</s:a>
		
		<s:a href="formularioExame">Criar Exame</s:a>
		
		<br />
	
		<form class="d-flex flex-column" action="listarExames" method="POST">
            <s:textfield cssClass="d-flex flex-column" name="id" label="Codigo" />
            
            <s:textfield cssClass="d-flex flex-column" name="name" label="Nome do exame" />
            
            <s:select list="#{'all':'Ambos','True':'Ativo', 'False':'Inativo'}" name="active" label="Status" />
            
            <s:submit cssClass="dark-green text-white" value="Buscar" />
        </form>
        
		<table>
			<thead>
				<tr>
					<th>codigo</th>
					<th>Nome</th>
					<th>Ativo</th>
					<th colspan="2">Ações</th>
				</tr>
			</thead>
			
			<s:iterator value="exams" var="exam">
				<tr>
					<td>
						<s:property value="#exam.id"/>
					</td>
					<td>
						<s:property value="#exam.name"/>
					</td>
					<td>
						<s:property value="#exam.active"/>
					</td>
					<td>
						<s:a href="revisarFormularioExame?id=%{#exam.id}">
							Atualizar
						</s:a>
					</td>
					<td>
						<s:a href="deletarExame?id=%{#exam.id}">
							deletar
						</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
		
		<s:a href="listarExames?page=%{page - 1}" disabled="%{page == 0}"><</s:a>
		
		<s:property value="page"/>/<s:property value="pagination.getQtypages()" />
		
		<s:a href="listarExames?page=%{page + 1}" disabled="%{page >= pagination.getQtypages()}" >></s:a>
	</body>
</html>