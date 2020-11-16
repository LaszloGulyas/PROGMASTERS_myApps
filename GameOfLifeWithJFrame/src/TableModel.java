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

import javax.swing.table.AbstractTableModel;

/**
 * Ennek a feladata, hogy információkat szolgáltasson a táblázat méretéről és a cellák tartalmáról
 */
public class TableModel extends AbstractTableModel {

    private GameOfLife gameOfLife;

    public TableModel(GameOfLife gameOfLife) {
        this.gameOfLife = gameOfLife;
    }

    @Override
    public int getRowCount() {
        return SpaceData.height;
    }

    @Override
    public int getColumnCount() {
        return SpaceData.width;
    }

    @Override
    public Object getValueAt(int y, int x) {

        //X koordináták az első sorban
        if (y == 0) {
            return "#" + x;
        }

        //Y koordináták az első oszlopban
        if (x == 0) {
            return "#" + y;
        }

        // üres cellák az utolsó sorban és oszlopban
        if (x == SpaceData.height - 1 || y == SpaceData.width - 1) {
            return "-";
        }

        //baktériumok élnek-e az adott helyen
        if (gameOfLife.isAlive(y, x)) {
            return "#";
        } else {
            return " ";
        }
    }
}
