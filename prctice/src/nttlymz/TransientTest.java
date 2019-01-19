package nttlymz;

import java.io.*;

/**
 * @author leetHuam
 * @version 1.0
 */
public class TransientTest {
    public static void main(String[] args) {
        User user = new User();
        user.setUsername("Alexia");
        user.setPassword("123456");

        System.out.println("read before serializable: ");
        System.out.println("username: " + user.getUsername());
        System.out.println("password: " + user.getPassword());

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("user.txt"))) {
            os.writeObject(user);
            os.flush();
            os.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("user.txt"))) {
            user = (User) oi.readObject();
            oi.close();
            System.out.println("\n read after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.out.println("password: " + user.getPassword());
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;
    private String username;
    private transient String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
