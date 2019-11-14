package com.aowin.stuff.Listener;

import com.aowin.stuff.View.MainWin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwitchButtonListener implements ActionListener {
    private MainWin mainWin;

    public SwitchButtonListener(MainWin mainWin) {
        this.mainWin = mainWin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "员工管理": {
                if (mainWin.getUser().isVisible()) {
                    return;
                } else {
                    mainWin.setVisible(false);
                    mainWin.getDepartment().setVisible(false);
                    mainWin.getTextArea().setVisible(false);
                    mainWin.getChatButton().setVisible(false);
                    mainWin.getUser().setVisible(true);
                    mainWin.getOptionButtons().setVisible(true);
                    mainWin.setVisible(true);
                }
                break;
            }
            case "部门管理": {
                if (mainWin.getDepartment().isVisible()) {
                    return;
                } else {
                    mainWin.setVisible(false);
                    mainWin.getUser().setVisible(false);
                    mainWin.getTextArea().setVisible(false);
                    mainWin.getChatButton().setVisible(false);
                    mainWin.getDepartment().setVisible(true);
                    mainWin.getOptionButtons().setVisible(true);
                    mainWin.setVisible(true);
                }
                break;
            }
            case "问题讨论": {
                if (mainWin.getTextArea().isVisible()) {
                    return;
                } else {
                    mainWin.setVisible(false);
                    mainWin.getUser().setVisible(false);
                    mainWin.getDepartment().setVisible(false);
                    mainWin.getOptionButtons().setVisible(false);
                    mainWin.getTextArea().setVisible(true);
                    mainWin.getChatButton().setVisible(true);
                    mainWin.setVisible(true);
                }
                break;
            }
        }
    }
}
