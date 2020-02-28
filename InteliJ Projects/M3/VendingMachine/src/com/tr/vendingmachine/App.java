package com.tr.vendingmachine;

import com.tr.vendingmachine.controller.VendingMachineController;
import com.tr.vendingmachine.dao.*;
import com.tr.vendingmachine.service.VendingMachineServiceLayer;
import com.tr.vendingmachine.service.VendingMachineServiceLayerImpl;
import com.tr.vendingmachine.ui.UserIO;
import com.tr.vendingmachine.ui.UserIOFileImpl;
import com.tr.vendingmachine.ui.VendingMachineView;

public class App {

    public static void main(String[] args) throws VendingMachinePersistenceException {
	// write your code here
        String FILE_NAME = "items.txt";
        UserIO io = new UserIOFileImpl();
        VendingMachineView view = new VendingMachineView(io);
        VendingMachineDao dao = new VendingMachineDaoFileImpl(FILE_NAME);
        VendingMachineAuditDao audit = new VendingMachineAuditDaoImpl();
        VendingMachineServiceLayer service = new VendingMachineServiceLayerImpl(dao, audit);
        VendingMachineController controller = new VendingMachineController(view, service);
        controller.run();
    }
}
