package assignment02;

import java.util.GregorianCalendar;

public class LibraryBookGeneric<Type> extends Book {

  private Type holder;
  private GregorianCalendar dueDate;

  /**
   * @param isbn
   * @param author
   * @param title
   */
  public LibraryBookGeneric(long isbn, String author, String title) {
    super(isbn, author, title);
    holder = null;
    dueDate = null;
  }

  /**
   * @return the holder
   */
  public Type getHolder() {
    return holder;
  }

  /**
   * @return the due date
   */
  public GregorianCalendar getDueDate() {
    return dueDate;
  }

  /**
   * @return true if no holder for the book now
   */
  public boolean isCheckedIn() {
    return holder == null;
  }

  /**
   * set the holder
   * @param holder
   */
  public void setHolder(Type holder) {
    this.holder = holder;
  }

  /**
   * set the due date
   * @param dueDate
   */
  public void setDueDate(GregorianCalendar dueDate) {
    this.dueDate = dueDate;
  }
}
