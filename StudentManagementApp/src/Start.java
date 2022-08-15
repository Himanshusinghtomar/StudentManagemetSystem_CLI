import java.io.*;


import com.student.manage.Student;
import com.student.manage.StudentDao;


public class Start {

	public static void main(String[] args) throws Exception
	{
		//Scanner inp = new Scanner(System.in);
		
		System.out.println("**************Welcome To Student Management***************");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\n");
		while(true)
		{
			System.out.println("PRESS 1 to Add Students in DATABASE");
			System.out.println("PRESS 2 to Delete Students in DATABASE");
			System.out.println("PRESS 3 to Display Students in DATABASE");
			System.out.println("PRESS 4 to Update Student in DATABASE");
			System.out.println("PRESS 5 to EXIT The App");
			
			int flag = Integer.parseInt(br.readLine());
			
			if(flag == 1)
			{
				//Add the Student in DataBase
				System.out.print("Enter name : ");
				String name = br.readLine();//here buffer have \n escape sequence left
				
				
				System.out.print("Enter Student phone : ");
				String phone = br.readLine();
				
				System.out.print("Enter Student City : ");
				String city = br.readLine();
				
				//create student object 
				Student s = new Student(name,phone,city);
				boolean answer = StudentDao.insertStudentToDB(s);
				if(answer)
				{
					System.out.println("Student is inserted");
				}
				else
				{
					System.out.println("Somthing is wrong");
				}
			}
			else if(flag ==2)
			{
				//Delete the Student from DataBase
				System.out.println("Enter Studetnt Id to Delete : ");
				int userId = Integer.parseInt(br.readLine());
				boolean answer = StudentDao.deleteStudent(userId);
				if(answer)
				{
					System.out.println("Student is Deleted");
				}
				else
				{
					System.out.println("Somthing is wrong");
				}
			}
			else if(flag ==3)
			{
				//Display Data
				boolean answer = StudentDao.ShowAllStudents();
				if(answer)
				{
					System.out.println("Student is Fetched");
				}
				else
				{
					System.out.println("Somthing is wrong");
				}
			}
			else if(flag ==4)
			{
				//Update Data
				System.out.println("Enter changed data  : ");
				String changeData = br.readLine();
				
				System.out.println("Enter column Number  : ");
				int studentId = Integer.parseInt(br.readLine());
				
				boolean answer = StudentDao.updateStudents(changeData,studentId);
				if(answer)
				{
					System.out.println("Student Data is Update");
				}
				else
				{
					System.out.println("Somthing is wrong");
				}
			}
			else if(flag ==5)
			{
				//Exit from loop
				break;
			}

		}
		System.out.println("\n");
		System.out.println("***************Thank You For using***************");
	}
}

