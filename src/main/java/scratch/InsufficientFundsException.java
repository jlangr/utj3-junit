package scratch;

class InsufficientFundsException extends RuntimeException {
   public InsufficientFundsException(String message) {
      super(message);
   }

   private static final long serialVersionUID = 1L;
}
