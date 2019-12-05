package mypackage1;

public class Orden 
{
  String codigo;
  String nombre;
  String fecha_orden;
  String fecha_entrega;

  public Orden()
  {
  }

  public String getCodigo()
  {
    return codigo;
  }

  public void setCodigo(String newCodigo)
  {
    codigo = newCodigo;
  }

  public String getNombre()
  {
    return nombre;
  }

  public void setNombre(String newNombre)
  {
    nombre = newNombre;
  }

  public String getFecha_orden()
  {
    return fecha_orden;
  }

  public void setFecha_orden(String newFecha_orden)
  {
    fecha_orden = newFecha_orden;
  }

  public String getFecha_entrega()
  {
    return fecha_entrega;
  }

  public void setFecha_entrega(String newFecha_entrega)
  {
    fecha_entrega = newFecha_entrega;
  }
}