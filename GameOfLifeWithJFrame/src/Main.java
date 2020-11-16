/*
 * Copyright © Progmasters (QTC Kft.), 2018.
 * All rights reserved. No part or the whole of this Teaching Material (TM) may be reproduced, copied, distributed, 
 * publicly performed, disseminated to the public, adapted or transmitted in any form or by any means, including 
 * photocopying, recording, or other electronic or mechanical methods, without the prior written permission of QTC Kft. 
 * This TM may only be used for the purposes of teaching exclusively by QTC Kft. and studying exclusively by QTC Kft.’s 
 * students and for no other purposes by any parties other than QTC Kft.
 * This TM shall be kept confidential and shall not be made public or made available or disclosed to any unauthorized person.
 * Any dispute or claim arising out of the breach of these provisions shall be governed by and construed in accordance with the laws of Hungary.
 */

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        GameOfLife gameOfLife = new GameOfLife();

        JTable jTable = createWindowAndTable(gameOfLife);

        while (true) {

            updateUI(jTable);

            Thread.sleep(SpaceData.speed); //wait

            gameOfLife.updateToNextGenerataion();

        }

    }

    private static JTable createWindowAndTable(final GameOfLife gameOfLife) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(SpaceData.width * 25, SpaceData.height * 25);

        TableModel tableModel = new TableModel(gameOfLife);

        JTable table = new JTable(tableModel);
        table.setBackground(Color.lightGray);

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        table.setModel(tableModel);

        frame.setVisible(true);

        return table;
    }

    private static void updateUI(JTable table) {
        SwingUtilities.invokeLater(() -> table.updateUI());

    }
}