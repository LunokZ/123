<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="esS">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrap-theme.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrapValidator.min.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/dataTables.bootstrap.min.css"/>" rel="stylesheet">
<link href="<c:url value="/resources/css/bootstrapValidator.min.css"/>" rel="stylesheet">


<script type="text/javascript" src="<c:url value="/resources/js/jquery.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/bootstrapValidator.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/jquery.dataTables.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/dataTables.bootstrap.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/resources/js/index.js" />"></script>


<script type="text/javascript" src="<c:url value="/resources/sweetalert/sweetalert.min.js" />"></script>



<title>Medicamento</title>
<style>
	.btn-primary{
		background: #46b8da;
		border-color:#46b8da;
		color: white !important;
		text-align: center;
		font-size: 14px;
	}
	.btn-primary:hover{
		background: #46b8da;
		border-color:#46b8da;
		color: white !important;
	}
	.btn-primary:focus{
		background: #46b8da;
		border-color:#46b8da;
		color: white !important;
	}	
</style>


</head>
<body>
	<div class="container">
		<h3 align="center">Lista Medicamento</h3>
					<button type="button" data-toggle='modal' onclick="mostrarVentana()"  
					class='btn btn-primary' id="validateBtnw2" >Nuevo Medicamento</button><br>&nbsp;<br>		
			<div id="divMedicamento">
		 								<table id="id_table_medicamento" class="table table-striped table-bordered" >
												<thead>
														<tr>
															<th>Codigo</th>
															<th>Nombre</th>
															<th>Laboratorio</th>
															<th>Stock</th>
															<th>Precio</th>
															<th>Fecha</th>
															<th></th>
															<th></th>
														</tr>
												</thead>
												<tbody>
																									
												</tbody>
											</table>	
			</div>	
			 
		<!-- Nuevo y Acualizar -->
		<div class="modal fade" id="id_modal_medicamento">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Medicamento</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <div class="modal-body">
				<div class="panel panel-info">
					<div class="panel-heading">
						<div class="panel-title" id="id_mensaje">Registra Medicamento</div>
					</div>
					<div class="panel-body">
						<form action="#" class="form-horizontal" id="id_registraMedicamento"
								method="post"  data-toggle="validator" role="form">
							<input type="hidden"  id="id_codigo" name="codigo">
							<div class="form-group">
								<label for="i_nombre" class="col-lg-3 control-label">Nombre</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_nombre" 
										name="nombre" placeholder="Ingresar nombre"/>
								</div>
							</div>
							<div class="form-group">
								<label for="i_laboratorio" class="col-lg-3 control-label">Laboratorio</label>
								<div class="col-lg-9">
									<select id="id_laboratorio" name="laboratorio" class='form-control'>
											  <option value=" ">[SELECCIONE]</option>
    
								    </select>
								</div>
							</div>
							<div class="form-group">
								<label for="i_stock" class="col-lg-3 control-label">Stock</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_stock" name="stock"/>
								</div>
							</div>
							<div class="form-group">
								<label for="i_precio" class="col-lg-3 control-label">Precio</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_precio" name="precio"/>
								</div>
							</div>
							<div class="form-group">
								<label for="i_fecha" class="col-lg-3 control-label">Fecha</label>
								<div class="col-lg-9">
									<input type="text" class="form-control" id="id_fecha" name="fecha"/>
								</div>
							</div>												
						</form>
					</div>
			</div>
			</div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-primary" onclick="postValidarRegistra()">Guardar</button>
                <button type="button" class="btn btn-danger" id="resetBtn">Cerrar</button>
		        
		      </div>
		    </div>
		  </div>
		</div>
		<!-- FIN Nuevo y Acualizar-->	
	</div>

<script type="text/javascript">
	function comboLaboratorio(){
		$.getJSON("listaLaboratorios",{},function(response){
		 $.each(response.dataLaboratorios,function(index,item){
				$("#id_laboratorio").append("<option value='"+
								item.codLaboratorio+"'>"+
								item.desLaboratorio+"</option>");
			})
		})
	}
	function mostrarVentana(){
		$("#id_modal_medicamento").modal("show");
	} 
	function tablaMedicamento(){
		$.getJSON("listaMedicamentos",{},function(response){
		$("#id_table_medicamento").DataTable().destroy(); 
		$("#id_table_medicamento tbody").empty();
		$.each(response.dataMedicamentos,function(index,item){
			 var editar='<button type="button" class="btn btn-success" onclick="editar('+item.codMedicamento+')">Editar</button>';
			 var eliminar='<button type="button" class="btn btn-danger" onclick="eliminar('+item.codMedicamento+')">Eliminar</button>';
				$("#id_table_medicamento").append("<tr><td>"+    
						item.codMedicamento+"</td><td>"+
						item.nomMedicamento+"</td><td>"+
						item.laboratorio.desLaboratorio+"</td><td>"+
						item.stock+"</td><td>"+
						item.precio+"</td><td>"+
						item.fechaVencimiento+"</td><td>"+
						editar+"</td><td>"+
						eliminar+"</td></tr>");
			})
			$("#id_table_medicamento").DataTable().draw();
			$("#id_table_medicamento").DataTable();
		})
	}	
	function editar(cod){
		alert(cod);
	}
	function eliminar(cod){
		swal({
			  title: "Sistema",
			  text: "Seguro de eliminar el registro con Código :"+cod,
			  icon: "warning",
			  buttons: true,
			  dangerMode: true,
			})
			.then((willDelete) => {
			  if (willDelete) {
			    //AJAX
				 $.ajax({
						url:'eliminarMedicamento',
						type:'POST',
						data:{codigo:cod},
						success:function(response){
							if(response.mEliminar==1)
								swal("Registro eliminado");
							else
								swal("Error en la eliminacion");
							tablaMedicamento();
						},
						error:function(e){
							swal("Error en el codigo fuente");
						}
				 }) 
			  } else {
			    swal("Your imaginary file is safe!");
			  }
			});
	}
	
	
</script>
<script type="text/javascript">
	$(document).ready(function() {
		comboLaboratorio();	
		tablaMedicamento();
	} );
</script>

</body>
</html>












