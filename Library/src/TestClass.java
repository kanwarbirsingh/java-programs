package assignTwoStudent30130595;

public class TestClass 
{

	Library libitem;
	
	public TestClass()
	{
		libitem = new Library();
	}
	
	public Book testrun1a ()
	{
		Book b = new Book("Harry Potter","1234",2001,false,45.21,"JK Rowling",805,true,true,"Scholastic");
		System.out.println(b.toString());
		return b;
	}
	
	public Book testrun1b ()
	{
		Book b1 = new Book("Harry Potter","1234",2001,false,45.21,"JK Rowling",805,true,true,"Scholastic");
		b1.setyearOfPublication(2011);
		System.out.println("");
		System.out.println(b1.toString());
		return b1;
	}
	
	public Magazine testrun2()
	{
		Magazine m = new Magazine("GQ","12",2011,false,74.58,805,true,"XYZ");
		System.out.println("");
		System.out.println(m.toString());
		return m;
	}
	
	public void testrun3(Book _b, Book _b1, Magazine _m) {
		// test adding 3 shapes to the shapes list
		if(!libitem.addItem(_b)) System.out.println("Not able to add library item "+_b);
		if(!libitem.addItem(_b1)) System.out.println("Not able to add library item "+_b1);
		if(!libitem.addItem(_m)) System.out.println("Not able to add library item "+_m);
		System.out.println("");
		System.out.println("My list of Library Items:");
		System.out.println("");
		System.out.println(libitem.toString() );
		
	}
	
	public void testrun4() {
		// test sorting list of library items
		libitem.mySort();
		System.out.println("My list of sorted library items:");
		System.out.println("");
		System.out.println(libitem.toString() );
		
	}
	/*  Main for TestClass.java
	public static void main(String[] args)
	{
		TestClass t = new TestClass();
		Book testbook1 = t.testrun1a();
		Book testbook2 = t.testrun1b();
		Magazine testmag = t.testrun2();
		t.testrun3(testbook1, testbook2, testmag);
		t.testrun4();
	}*/

}
