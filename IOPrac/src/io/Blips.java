package io;

import java.io.*;

/**
 * @author leetHuam
 * @version 1.0
 */
class Blip1 implements Externalizable {
    public Blip1() {
        System.out.println("Blip1 constructor");
    }

    public void writeExternal(ObjectOutput output) throws IOException{
        System.out.println("Blip1.writeExternal");
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException{
        System.out.println("Blip2.readExternal");
    }
}

class Blip2 implements Externalizable {
    public Blip2() {
        System.out.println("Blip2 constructor");
    }

    public void writeExternal(ObjectOutput output) throws IOException{
        System.out.println("Blip2.writeExternal");
    }

    public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException{
        System.out.println("Blip2.readExternal");
    }
}

public class Blips {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        System.out.println("Constructing objects:");
        Blip1 blip1 = new Blip1();
        Blip2 blip2 = new Blip2();
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Blips.out"));
        System.out.println("Saving objects:");
        o.writeObject(blip1);
        o.writeObject(blip2);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("Blips.out"));
        System.out.println("Recovering b1:");
        blip1 = (Blip1) in.readObject();
        blip2 = (Blip2) in.readObject();

    }
}