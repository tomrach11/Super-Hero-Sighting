package com.tr.vendingmachine;

import com.tr.vendingmachine.controller.VendingMachineController;
import com.tr.vendingmachine.dao.VendingMachineDao;
import com.tr.vendingmachine.dao.VendingMachineDaoFileImpl;
import com.tr.vendingmachine.service.VendingMachineServiceLayer;
import com.tr.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.tr.vendingmachine.ui.UserIO;
import com.tr.vendingmachine.ui.UserIOFileImpl;
import com.tr.vendingmachine.ui.VendingMachineView;

public class App {

    public static void main(String[] args) {
	// write your code here
        UserIO io = new UserIOFileImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineDao dao = new VendingMachineDaoFileImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao);
        VendingMachineController controller = new VendingMachineController(view, service);
        controller.run();
    }
}
