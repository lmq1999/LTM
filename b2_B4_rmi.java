//Interface

package swing_pkg.rmi;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
 public double square(double a) throws RemoteException;
}

//Implement

package swing_pkg.rmi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements ICalculator{
 public CalculatorImpl() throws RemoteException{
   public double square(double a) throws RemoteException {
      return a*a;
   }
 }
}

//Client
package swing_pkg.rmi;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class caculatorclient {

public static void main(String[] args) {
  try {

    Registry reg = LocateRegistry.getRegistry("localhost", 1000);

    ICalculator cal = (ICalculator) reg.lookup("RMICalSer");

    double result = cal.square(Double.parseDouble(txtNum.getText()));

    lblResult.setText(String.valueOf(result));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

//Server

package swing_pkg.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class caculatorserver {
  public static void main(String[] args) {
  try {
    Registry reg = LocateRegistry.createRegistry(1000);
    CalculatorImpl ci = new CalculatorImpl();
    reg.bind("RMICalSer", ci);
  } catch (Exception e) {
    e.printStackTrace();
  }
  }
}
