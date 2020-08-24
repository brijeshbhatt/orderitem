package brijesh.bhatt.exception;

public class ItemNotFoundException extends RuntimeException {

   public ItemNotFoundException(int id){
       super("Order Item with id: "+ id +" does not present in DB.");
   }

}
