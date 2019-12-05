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
public class IngresoAction extends Action 
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
    IngresoActionForm ingresoActionForm = (IngresoActionForm) form;
    String codigo = ingresoActionForm.getCodigo();
    String nombre = ingresoActionForm.getNombre();
    ConnectDB conn =new ConnectDB ();
    ResultSet rsConsulta = null;
    try
    {
    String cadena="select id,name from s_customer where id='"+codigo+"'";
    System.out.println(cadena);
    rsConsulta = conn.getData(cadena);
    if (rsConsulta.next()){
       String codigo_db = rsConsulta.getString("id");
       String nombre_db = rsConsulta.getString("name");
       if(codigo_db.equals(codigo) && nombre_db.equals(nombre)){
          request.getSession().setAttribute("nombre",nombre);
          return mapping.findForward("success");
       }
       else{
          return mapping.findForward("failure");
       }
    }
    else{
       return mapping.findForward("failure");
    }
    }
    catch(Exception e)
    {
      e.printStackTrace();
      return (mapping.findForward("failure"));
    }
    finally
    {
    conn.closeConnection();	
    }
  }
}