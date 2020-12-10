/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.clsPosiblesClientes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Maria Angelica
 */
@WebServlet(name = "PosiblesClientesController", urlPatterns = {"/PosiblesClientesController"})
public class PosiblesClientesController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //VALIDAMOS QUE SE HAYA PRESIONADO EL BOTON DE GUARDAR
        if (request.getParameter("btnGuardar") != null) {
            btnGuardar(request, response);
        } else if (request.getParameter("btnModificar") != null) {
            btnModificar(request, response);
        } else if (request.getParameter("btnCancelar") != null) {

        } else if (request.getParameter("codigoSeleccionado") != null) {
            if (request.getParameter("stOpcion").equals("M")) {
                cargarModificar(request, response);
            } else if (request.getParameter("stOpcion").equals("E")) {
                btnEliminar(request, response);
            }
        }
    }

    public void btnModificar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();

            HttpSession session = request.getSession(true);

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }

            int inPosicion = 0;
            for (clsPosiblesClientes elem : lstclsPosiblesClientes) {
                if (elem.getInCodigo() == Integer.parseInt(request.getParameter("codigoModificar"))) {
                    break;
                }
                inPosicion++;
            }

            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            //ASIGNACION DE ATRIBUTOS Y PROPIEDADES
            if (request.getParameter("txtEmpresa") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStCorreoElecronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStMovil(request.getParameter("txtMovil"));
            }
            if (request.getParameter("txtWeb") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStSitioWeb(request.getParameter("txtWeb"));
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                //MODELO HIJO
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                String atDescripcion = "";

                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    atDescripcion = "Aviso";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    atDescripcion = "Llamada no solicitada";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    atDescripcion = "Recomendacion de empleado";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    atDescripcion = "Recomendacion Externa";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    atDescripcion = "Tienda en linea";
                }

                obclsFuentePosibleCliente.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                lstclsPosiblesClientes.get(inPosicion).setObcclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                //MODELO HIJO
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                String atDescripcion = "";

                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    atDescripcion = "Intento de contacto";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    atDescripcion = "Contactar en el futuro";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    atDescripcion = "Contactado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    atDescripcion = "Posible Cliente no solicitado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    atDescripcion = "Posible cliente perdido";
                }

                obclsEstadoPosibleCliente.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                lstclsPosiblesClientes.get(inPosicion).setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }

            if (request.getParameter("ddlSector") != null) {
                //MODELO HIJO
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                String atDescripcion = "";

                if (request.getParameter("ddlSector").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlSector").equals("2")) {
                    atDescripcion = "Aps(provedor de servicios de aplicaciones";
                } else if (request.getParameter("ddlSector").equals("3")) {
                    atDescripcion = "OEM de datos";
                } else if (request.getParameter("ddlSector").equals("4")) {
                    atDescripcion = "ERP(Planificacion de recursos de empresa";
                } else if (request.getParameter("ddlSector").equals("5")) {
                    atDescripcion = "Gobierno/Ejercito";
                } else if (request.getParameter("ddlSector").equals("6")) {
                    atDescripcion = "Empresa Grande";
                }

                obclsSector.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                lstclsPosiblesClientes.get(inPosicion).setObclsSector(obclsSector);
            }
            if (request.getParameter("txtCantidadEmpleados") != null) {
                lstclsPosiblesClientes.get(inPosicion).setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                lstclsPosiblesClientes.get(inPosicion).setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }

            if (request.getParameter("ddlCalificacion") != null) {
                //MODELO HIJO
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                String atDescripcion = "";

                if (request.getParameter("ddlCalificacion").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    atDescripcion = "Abquirido";
                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    atDescripcion = "Activo";
                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    atDescripcion = "Contactado";
                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    atDescripcion = "Proyecto cancelado";
                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    atDescripcion = "Apagar";
                }

                obclsCalificacion.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                lstclsPosiblesClientes.get(inPosicion).setObclsCalificacion(obclsCalificacion);
            }
            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';

                lstclsPosiblesClientes.get(inPosicion).setChNoParticipacionCorreoEletronico(chSeleccion);
            } else {
                lstclsPosiblesClientes.get(inPosicion).setChNoParticipacionCorreoEletronico('N');
            }

            if (request.getParameter("txtIDSkype") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoelectronicosecundario") != null) {
                lstclsPosiblesClientes.get(inPosicion).setStCorreoElecronicoSecundario(request.getParameter("txtCorreoelectronicosecundario"));
            }

            //CREAMOS LA VARIABLE DE SESSION
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);

            //DEFINIR PARAMETROS DESDE EL CONTROLADOR
            request.setAttribute("stMensaje", "se realizo proceso con exito");
            request.setAttribute("stTipo", "success");

            //REDIRECCIONO Y ENVIO LOS VALORES
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void btnEliminar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {
        try {

            //MODELO SOBRE EL QUE ESTAMOS TRABAJANDO
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            //LISTA DE OBJETOS DONDE ESTA LA INFORMACION GUARDADA
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();

            HttpSession session = request.getSession(true);

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");

            }

            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPosiblesClientes = item;
                    lstclsPosiblesClientes.remove(item);
                    break;
                }

            }

            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);
            request.setAttribute("stTipo", "success");
            request.setAttribute("stMensaje", "se realizo proceso con exito.");
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void cargarModificar(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException {

        try {
            //MODELO SOBRE EL QUE ESTAMOS TRABAJANDO
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            //LISTA DE OBJETOS DONDE ESTA LA INFORMACION GUARDADA
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes = new ArrayList<Models.clsPosiblesClientes>();

            HttpSession session = request.getSession(true);

            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");

            }
            for (Models.clsPosiblesClientes item : lstclsPosiblesClientes) {
                if (item.getInCodigo() == Integer.parseInt(request.getParameter("codigoSeleccionado"))) {
                    obclsPosiblesClientes = item;

                }
            }
            request.setAttribute("obclsPosiblesClientes", obclsPosiblesClientes);
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {

            request.setAttribute("stTipo", "error");
            request.setAttribute("stMensaje", ex.getMessage());
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    public void btnGuardar(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        try {

            //DEFINICION DE MODELOS
            Models.clsPosiblesClientes obclsPosiblesClientes = new Models.clsPosiblesClientes();
            Models.clsFuentePosibleCliente obclsFuentePosibleCliente = new Models.clsFuentePosibleCliente();
            Models.clsEstadoPosibleCliente obclsEstadoPosibleCliente = new Models.clsEstadoPosibleCliente();
            Models.clsSector obclsSector = new Models.clsSector();
            Models.clsCalificacion obclsCalificacion = new Models.clsCalificacion();

            //ASIGNACION DE ATRIBUTOS Y PROPIEDADES
            if (request.getParameter("txtEmpresa") != null) {
                obclsPosiblesClientes.setStEmpresa(request.getParameter("txtEmpresa"));
            }
            if (request.getParameter("txtNombre") != null) {
                obclsPosiblesClientes.setStNombre(request.getParameter("txtNombre"));
            }
            if (request.getParameter("txtApellidos") != null) {
                obclsPosiblesClientes.setStApellidos(request.getParameter("txtApellidos"));
            }
            if (request.getParameter("txtTitulo") != null) {
                obclsPosiblesClientes.setStTitulo(request.getParameter("txtTitulo"));
            }
            if (request.getParameter("txtCorreoElectronico") != null) {
                obclsPosiblesClientes.setStCorreoElecronico(request.getParameter("txtCorreoElectronico"));
            }
            if (request.getParameter("txtTelefono") != null) {
                obclsPosiblesClientes.setStTelefono(request.getParameter("txtTelefono"));
            }
            if (request.getParameter("txtFax") != null) {
                obclsPosiblesClientes.setStFax(request.getParameter("txtFax"));
            }
            if (request.getParameter("txtMovil") != null) {
                obclsPosiblesClientes.setStMovil(request.getParameter("txtMovil"));
            }
            if (request.getParameter("txtWeb") != null) {
                obclsPosiblesClientes.setStSitioWeb(request.getParameter("txtWeb"));
            }
            if (request.getParameter("ddlFuentePosibleCliente") != null) {
                //MODELO HIJO
                obclsFuentePosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlFuentePosibleCliente")));

                String atDescripcion = "";

                if (request.getParameter("ddlFuentePosibleCliente").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("2")) {
                    atDescripcion = "Aviso";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("3")) {
                    atDescripcion = "Llamada no solicitada";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("4")) {
                    atDescripcion = "Recomendacion de empleado";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("5")) {
                    atDescripcion = "Recomendacion Externa";
                } else if (request.getParameter("ddlFuentePosibleCliente").equals("6")) {
                    atDescripcion = "Tienda en linea";
                }

                obclsFuentePosibleCliente.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObcclsFuentePosibleCliente(obclsFuentePosibleCliente);
            }

            if (request.getParameter("ddlEstadoPosibleCliente") != null) {
                //MODELO HIJO
                obclsEstadoPosibleCliente.setInCodigo(Integer.parseInt(request.getParameter("ddlEstadoPosibleCliente")));

                String atDescripcion = "";

                if (request.getParameter("ddlEstadoPosibleCliente").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("2")) {
                    atDescripcion = "Intento de contacto";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("3")) {
                    atDescripcion = "Contactar en el futuro";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("4")) {
                    atDescripcion = "Contactado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("5")) {
                    atDescripcion = "Posible Cliente no solicitado";
                } else if (request.getParameter("ddlEstadoPosibleCliente").equals("6")) {
                    atDescripcion = "Posible cliente perdido";
                }

                obclsEstadoPosibleCliente.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsEstadoPosibleCliente(obclsEstadoPosibleCliente);
            }

            if (request.getParameter("ddlSector") != null) {
                //MODELO HIJO
                obclsSector.setInCodigo(Integer.parseInt(request.getParameter("ddlSector")));

                String atDescripcion = "";

                if (request.getParameter("ddlSector").equals("1")) {
                    atDescripcion = "Ninguno";
                } else if (request.getParameter("ddlSector").equals("2")) {
                    atDescripcion = "Aps(provedor de servicios de aplicaciones";
                } else if (request.getParameter("ddlSector").equals("3")) {
                    atDescripcion = "OEM de datos";
                } else if (request.getParameter("ddlSector").equals("4")) {
                    atDescripcion = "ERP(Planificacion de recursos de empresa";
                } else if (request.getParameter("ddlSector").equals("5")) {
                    atDescripcion = "Gobierno/Ejercito";
                } else if (request.getParameter("ddlSector").equals("6")) {
                    atDescripcion = "Empresa Grande";
                }

                obclsSector.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsSector(obclsSector);
            }
            if (request.getParameter("txtCantidadEmpleados") != null) {
                obclsPosiblesClientes.setInCantidadEmpleados(Integer.parseInt(request.getParameter("txtCantidadEmpleados")));
            }
            if (request.getParameter("txtIngresosAnuales") != null) {
                obclsPosiblesClientes.setDbIngresosAnuales(Double.parseDouble(request.getParameter("txtIngresosAnuales")));
            }

            if (request.getParameter("ddlCalificacion") != null) {
                //MODELO HIJO
                obclsCalificacion.setInCodigo(Integer.parseInt(request.getParameter("ddlCalificacion")));

                String atDescripcion = "";

                if (request.getParameter("ddlCalificacion").equals("1")) {
                    atDescripcion = "Ninguna";
                } else if (request.getParameter("ddlCalificacion").equals("2")) {
                    atDescripcion = "Abquirido";
                } else if (request.getParameter("ddlCalificacion").equals("3")) {
                    atDescripcion = "Activo";
                } else if (request.getParameter("ddlCalificacion").equals("4")) {
                    atDescripcion = "Contactado";
                } else if (request.getParameter("ddlCalificacion").equals("5")) {
                    atDescripcion = "Proyecto cancelado";
                } else if (request.getParameter("ddlCalificacion").equals("6")) {
                    atDescripcion = "Apagar";
                }

                obclsCalificacion.setStDescripcion(atDescripcion);

                //ASIGNO AL MODELO PADRE
                obclsPosiblesClientes.setObclsCalificacion(obclsCalificacion);
            }
            if (request.getParameter("chkNoParticipacionCorreoElectronico") != null) {

                char chSeleccion = request.getParameter("chkNoParticipacionCorreoElectronico").equals("on")
                        ? 'S' : 'N';

                obclsPosiblesClientes.setChNoParticipacionCorreoEletronico(chSeleccion);
            } else {
                obclsPosiblesClientes.setChNoParticipacionCorreoEletronico('N');
            }
            if (request.getParameter("txtIDSkype") != null) {
                obclsPosiblesClientes.setStIDSkype(request.getParameter("txtIDSkype"));
            }
            if (request.getParameter("txtTwitter") != null) {
                obclsPosiblesClientes.setStTwitter(request.getParameter("txtTwitter"));
            }
            if (request.getParameter("txtCorreoelectronicosecundario") != null) {
                obclsPosiblesClientes.setStCorreoElecronicoSecundario(request.getParameter("txtCorreoelectronicosecundario"));
            }

            HttpSession session = request.getSession(true);

            //LISTA DE OBJETOS
            List<Models.clsPosiblesClientes> lstclsPosiblesClientes
                    = new ArrayList<Models.clsPosiblesClientes>();

            //VALIDAMOS PREVIA EXISTENCIA DE LA VARIABLE DE SESSION
            if (session.getAttribute("session_lstclsPosiblesClientes") != null) {
                lstclsPosiblesClientes = (List<Models.clsPosiblesClientes>) session.getAttribute("session_lstclsPosiblesClientes");
            }

            //PARA CALCULO AUTOMATICO DEL CODIGO QUE IDENTIFICA ESE REGISTRO
            int inCodigo = lstclsPosiblesClientes.size() + 1;
            obclsPosiblesClientes.setInCodigo(inCodigo);

            //AGREGAMOS EL OBJETO A LA LISTA
            lstclsPosiblesClientes.add(obclsPosiblesClientes);
            //CREAMOS LA VARIABLE DE SESSION
            session.setAttribute("session_lstclsPosiblesClientes", lstclsPosiblesClientes);

            //DEFINIR PARAMETROS DESDE EL CONTROLADOR
            request.setAttribute("stMensaje", "se realizo proceso con exito");
            request.setAttribute("stTipo", "success");

            //REDIRECCIONO Y ENVIO LOS VALORES
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);

        } catch (Exception ex) {
            //DEFINIIR PARAMETROS DESDE EL CONTROLADOR
            request.setAttribute("stMensaje", ex.getMessage());
            request.setAttribute("stTipo", "error");

            //REDIRECCIONO Y ENVIO LOS VALORES
            request.getRequestDispatcher("PosiblesClientes.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
