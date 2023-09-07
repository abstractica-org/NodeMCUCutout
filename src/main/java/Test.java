import org.abstractica.javacsg.Geometry3D;
import org.abstractica.javacsg.JavaCSG;
import org.abstractica.javacsg.JavaCSGFactory;

public class Test
{
	public static void main(String[] args)
	{
		JavaCSG csg = JavaCSGFactory.createDefault();

		Geometry3D box = csg.box3D(10, 10, 10, false);

		csg.view(box);
	}
}
