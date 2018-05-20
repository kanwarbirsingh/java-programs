package assignTwoStudent30130595;

import java.util.Scanner;
public class LibrarySystem 
{
	Library libitem;
	
	public LibrarySystem()
	{
		libitem = new Library();
	}
	
	public Book run1a ()
	{
		Book b = new Book("Harry Potter","1234",2001,false,45.21,"JK Rowling",805,true,true,"Scholastic");
		System.out.println("Title\t\tID Code\tYear of Publication\tOn Loan\tReplacement Cost\tAuthor\tNumber Of Pages\tHardback?\tFiction\tPublisher");
		System.out.println(b.toString());
		return b;
	}
	
	public Book run1b ()
	{
		Book b1 = new Book("Harry Potter","1234",2001,false,45.21,"JK Rowling",805,true,true,"Scholastic");
		b1.setyearOfPublication(2011);
		
		
		System.out.println(b1.toString());
		return b1;
	}
	
	public Magazine run2()
	{
		Magazine m = new Magazine("GQ","12",2011,false,74.58,805,true,"XYZ");
		
		System.out.println("Title\t\tID Code\tYear of Publication\tOn Loan\tReplacement Cost\tNumber Of Pages\tHardback?\tPublisher");
		System.out.println(m.toString());
		return m;
	}
	
	public void run3(Book _b, Book _b1, Magazine _m) {
		// test adding 3 items to the library
		if(!libitem.addItem(_b)) System.out.println("Not able to add library item "+_b);
		if(!libitem.addItem(_b1)) System.out.println("Not able to add library item "+_b1);
		if(!libitem.addItem(_m)) System.out.println("Not able to add library item "+_m);
		System.out.println("");
		System.out.println("My list of Library Items:");
		System.out.println("");
		System.out.println(libitem.toString() );
		
	}
	
	public void run4() {
		// test sorting library items
		libitem.mySort();
		System.out.println("My list of sorted library items:");
		System.out.println("");
		System.out.println(libitem.toString() );
		
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		LibrarySystem ls = new LibrarySystem();
		char ch;
		do
		{
		System.out.println("Choose one of the following options:");
		System.out.println("1. Populate the Library.");
		System.out.println("2. Display Library Items in the Library.");
		System.out.println("3. Sort Library Items.");
		System.out.println("4. Exit");
		int choice = sc.nextInt();
		
		
		
		switch(choice)
		{
		case 1:
		Book testbook1 = ls.run1a();
		Book testbook2 = ls.run1b();
		Magazine testmag = ls.run2();
		break;
		case 2:
			Book testb1 = ls.run1a();
			Book testb2 = ls.run1b();
			Magazine testm = ls.run2();
		ls.run3(testb1, testb2, testm);
		break;
		case 3:
		ls.run4();
		break;
		case 4:
			System.exit(0);
		}
		System.out.println("Do you wish to continue? Press (y/n)");
		ch = sc.next().charAt(0);
		}
		while(ch == 'y' || ch == 'Y');
	}
}
