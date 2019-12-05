package mypackage1;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import oracle.jdbc.*;
import java.util.*;
public class SuccessAction extends Action 
{
  /**
   * This is the main action called from the Struts framework.
   * @param mapping The ActionMapping used to select this instance.
   * @param form The optional ActionForm bean for this request.
   * @param request The HTTP Request we are processing.
   * @param response The HTTP Response we are processing.
   */
  public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    SuccessActionForm successActionForm = (SuccessActionForm) form;
    String boton = successActionForm.getBoton();
    if(boton.equals("PRODUCTOS")){
        Connection cn = null;
        ConnectDB conn = new ConnectDB();
        ResultSet rsConsulta = null;
        try{
            cn = conn.conexion;
            String cadena = "select id,name,SHORT_DESC,SUGGESTED_WHLSL_PRICE from S_PRODUCT";
            System.out.println(cadena);
            rsConsulta = conn.getData(cadena);
            ArrayList productos = new ArrayList();
            while(rsConsulta.next()){
                Producto producto = new Producto();
                producto.setId(rsConsulta.getString("id"));
                producto.setName(rsConsulta.getString("name"));
                producto.setShort_desc(rsConsulta.getString("short_desc"));
                producto.setSuggested_whlsl_price(rsConsulta.getString("suggested_whlsl_price"));
                productos.add(producto);
            }
            listProductActionForm f = new listProductActionForm();
            f.setTabla(productos);
            request.getSession().setAttribute("productos",f);
            return mapping.findForward("listProduct");
        }
        catch(Exception e){
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        finally{
            conn.closeConnection();
        }
    }
    else if(boton.equals("ORDENES")){
        Connection cn = null;
        ConnectDB conn = new ConnectDB();
        ResultSet rsConsulta = null;
        try{
            cn = conn.conexion;
            String cadena = "select a.id,b.name,a.DATE_ORDERED,a.DATE_SHIPPED from s_ord a, S_CUSTOMER b "+
            "where a.CUSTOMER_ID=b.ID"+
            " and b.NAME='Unisports'";
            System.out.println(cadena);
            rsConsulta = conn.getData(cadena);
            ArrayList ordenes = new ArrayList();
            while(rsConsulta.next()){
                Orden orden = new Orden();
                orden.setCodigo(rsConsulta.getString("id"));
                orden.setNombre(rsConsulta.getString("name"));
                orden.setFecha_entrega(rsConsulta.getString("date_ordered"));
                orden.setFecha_orden(rsConsulta.getString("date_shipped"));
                ordenes.add(orden);
            }
            ListOrdersActionForm f = new ListOrdersActionForm();
            f.setTabla(ordenes);
            request.getSession().setAttribute("ordenes",f);
            return mapping.findForward("listOrders");
        }
        catch(Exception e){
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        finally{
            conn.closeConnection();
        }
    }
    else if(boton.equals("ACTUALIZAR DATOS")){
        Connection cn = null;
        ConnectDB conn = new ConnectDB();
        ResultSet rsConsulta = null;
        try{
            cn = conn.conexion;
            String cust_name = request.getSession().getAttribute("nombre").toString();
            String cadena = "select id, name, phone, address from S_CUSTOMER where name='"+cust_name+"'";
            System.out.println(cadena);
            rsConsulta = conn.getData(cadena);
            ArrayList clientes = new ArrayList();
            while(rsConsulta.next()){
                Costumer costumer = new Costumer();
                costumer.setId(rsConsulta.getString("id"));
                costumer.setName(rsConsulta.getString("name"));
                costumer.setPhone(rsConsulta.getString("phone"));
                costumer.setAddress(rsConsulta.getString("address"));
                clientes.add(costumer);
            }
            UpdateActionForm f = new UpdateActionForm();
            f.setTabla(clientes);
            request.getSession().setAttribute("clientes",f);
            return mapping.findForward("updateData");
        }
        catch(Exception e){
            e.printStackTrace();
            return mapping.findForward("failure");
        }
        finally{
            conn.closeConnection();
        }
    }
    else{
      return mapping.findForward("ingreso");
    }
  }
}