<%-- 
    Document   : PosiblesClientes
    Created on : 2/12/2020, 03:15:11 PM
    Author     : Maria Angelica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Posibles Clientes</title>
        <!-- Bootstrap core CSS-->
        <link href="vendor/bootstrap/css/bootstrap.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
        
        <link href="css/sweetalert.css" rel="stylesheet" type="text/css"/>
        <script src="js/sweetalert.min.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="container">
            <div class="card mx-auto mt-5">
                <div class="card-header">Crear Posibles Clientes</div>
                <div class="card-body">
                    <form action="PosiblesClientesController" method="POST">
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-6">
                                    <input type="submit" value="Guardar" class="btn btn-primary" name="btnGuardar"/>
                                    <input type="submit" value="Modificar" class="btn btn-primary" name="btnModificar"/>    
                                    <input type="submit" value="Cancelar" class="btn btn-primary" name="btnCancelar"/>  
                                    <input type="submit" value="Volver" class="btn btn-primary" name="btnVolver"/>  
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <h1>Informacion de Posible cliente</h1> 
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblEmpresa">Empresa</label>
                                    <input type="txt" placeholder="Empresa" name="txtNombre" class="form-control" required=""/>  
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblNombre">Nombre</label>
                                    <input type="txt" placeholder="Nombre" name="txtEmpresa" class="form-control" required=""/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblApellido">Apellidos</label>
                                    <input type="txt" placeholder="Apellido" name="txtApellidos" class="form-control" required=""/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTitulo">Titulo</label>
                                    <input type="txt" placeholder="Titulo" name="txtTitulo" class="form-control"/>
                                </div>
                            </div>
                        </div>
                        <!-- FILA -->
                        <div class="form-group">
                            <div class="form-row">
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblCorreoElectronico">Correo electronico</label>
                                    <input type="email" placeholder="Correo electronico" name="txtCorreoElectronico" class="form-control" required=""/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblTelefono">Telefono</label>
                                    <input type="txt" placeholder="Telefono" name="txtTelefono" class="form-control"/>
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblFax">Fax</label>
                                    <input type="txt" placeholder="Ingrese fax" name="txtFax" class="form-control"/> 
                                </div>
                                <!-- COLUMNA -->
                                <div class="col-md-3">
                                    <label name="lblMovil">Movil</label>
                                    <input type="txt" placeholder="Movil" name="txtMovil" class="form-control"/>    
                                </div>
                            </div>
                        </div>

                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblSitioWeb">Sitio web</label>
                                    <input type="txt" placeholder="sitio web" name="txtWeb" class="form-control"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblFuentePosibleCliente">Fuente de posible cliente</label>
                                    <select  class="form-control" name="ddlFuentePosibleCliente">
                                        <option value="1">Ninguno</option>
                                        <option value="2">Aviso</option>
                                        <option value="3">Llamada no solicitada</option>
                                        <option value="4">Recomendacion de empleado</option>
                                        <option value="5">Recomendacion externa</option>
                                        <option value="6">Tienda en linea</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblEstadoPosibleCliente">Estado de posible cliente</label>
                                    <select  class="form-control" name="ddlEstadoPosibleCliente">
                                        <option value="1" >Ninguno</option>
                                        <option value="2">Intento de contacto</option>
                                        <option value="3">Contactar en el futuro</option>
                                        <option value="4">Contactado</option>
                                        <option value="5">Posible cliente no solicitado</option>
                                        <option value="6">Posible cliente perdido</option>
                                    </select>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblSector">Sector</label>
                                    <select  class="form-control" name="ddlSector">
                                        <option value="1" >Ninguno</option>
                                        <option value="2">Aps(provedor de servicios de aplicaciones)</option>
                                        <option value="3">OEM de datos</option>
                                        <option value="4">ERP(Planificacion de recursos de empresa</option>
                                        <option value="5">Gobierno/Ejercito</option>
                                        <option value="6">Empresa Grande</option>
                                    </select>      
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblCantidadEmpleados">Cantidad de empleados</label>
                                    <input type="number" placeholder="Cantidad de empleados" name="txtcantidadEmpleados" class="form-control"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblIngresosAnuales"name=>Ingresos anuales</label>
                                    <input type="number" placeholder="Ingresos anuales" name="txtIngresosanuales" class="form-control"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblCalificacion"name="ddlCalificacion">Calificacion</label>
                                    <select  class="form-control" name="ddlCalificacion">
                                        <option value="1" >Ninguna</option>
                                        <option value="2">Abquirido</option>
                                        <option value="3">Activo</option>
                                        <option value="4">Contactado</option>
                                        <option value="5">Proyecto cancelado</option>
                                        <option value="6">Apagar</option>
                                    </select>      
                                </div>
                                <div class="col-md-3">
                                    <label name="lblNoParticipacionCorreoElectronico">                         
                                        <input type="checkbox"  name="chkNoParticipacionCorreoElectronico"/>
                                        No participacion correo electronico
                                    </label> 
                                </div>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="form-row">
                                <div class="col-md-3">
                                    <label name="lblIdskype">ID Skype</label>
                                    <input type="txt" placeholder="ID de skype" name="txtIDSkype" class="form-control"/>
                                </div>
                                <div class="col-md-3">
                                    <label name="lblTwitter">Twitter</label>
                                    <input type="txt" placeholder="Twitter" name="txtTwitter" class="form-control"/>
                                </div>
                                <div class="col-md-6">
                                    <label name="lblCorreo electronico">Correo electronico secundario</label>
                                    <input type="email" placeholder="Correo electronico secundario" name="txtCorreoelectronicosecundario" class="form-control"/>
                                </div>
                            </div>
                        </div>                
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>