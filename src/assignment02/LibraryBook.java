package assignment02;

import java.util.GregorianCalendar;

public class LibraryBook extends Book {

  private String holder;
  private GregorianCalendar dueDate;

  /**
   * initialize and set holder and title to null
   * 
   * @param isbn
   * @param author
   * @param title
   */
  public LibraryBook(long isbn, String author, String title) {
    super(isbn, author, title);
    holder = null;
    dueDate = null;
  }

  /**
   * @return the holder
   */
  public String getHolder() {
    return holder;
  }

  /**
   * @return the due date
   */
  public GregorianCalendar getDueDate() {
    return dueDate;
  }

  /**
   * @return true if no holder for the book
   */
  public boolean isCheckedIn() {
    return holder == null;
  }

  /**
   * set the holder
   * 
   * @param holder
   */
  public void setHolder(String holder) {
    this.holder = holder;
  }

  /**
   * set the due date
   * 
   * @param dueDate
   */
  public void setDueDate(GregorianCalendar dueDate) {
    this.dueDate = dueDate;
  }
}
