package mypackage1;

public class Producto 
{
  String id;
  String name;
  String short_desc;
  String suggested_whlsl_price;

  public Producto()
  {
  }

  public String getId()
  {
    return id;
  }

  public void setId(String newId)
  {
    id = newId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String newName)
  {
    name = newName;
  }

  public String getShort_desc()
  {
    return short_desc;
  }

  public void setShort_desc(String newShort_desc)
  {
    short_desc = newShort_desc;
  }

  public String getSuggested_whlsl_price()
  {
    return suggested_whlsl_price;
  }

  public void setSuggested_whlsl_price(String newSuggested_whlsl_price)
  {
    suggested_whlsl_price = newSuggested_whlsl_price;
  }
}