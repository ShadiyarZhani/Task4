package com.company;

import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        String hostName = "localhost";
        int port = 8080;
        String RMI_HOSTNAME = "java.rmi.server.hostname";
        String SERVICE_PATH = "//" + hostName + ":" + port + "/Service";

        try {
            System.setProperty(RMI_HOSTNAME, hostName);
            Service service = (Service) Naming.lookup(SERVICE_PATH);
            while (true) {
                Integer num = service.getMessage();
                if (num == null) {
                    System.out.println("Received none!");
                    break;
                } else {
                    System.out.println("Received: " + num);
                    service.storeCalculatedMessage(fibUnder(num));
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static int fibUnder(int count) {
        int n1=0,n2=1,n3,i, counter = 0;

        for(i=2;i<count;++i)//loop starts from 2 because 0 and 1 are already printed
        {
            n3=n1+n2;
            System.out.println("Fib: " + n3);
            n1=n2;
            n2=n3;
            counter++;
        }
        return counter;
    }

}