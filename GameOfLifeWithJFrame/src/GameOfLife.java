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

public class GameOfLife {

    //Ebben a 2d tömbben élnek vagy halnak a baktériumok, azaz 0-ák és 1-esek
    private int[][] space = SpaceData.initSpace;


    //Ez a függvény megállapítja, hogy az adott koordinátán élő baktérium van-e
    public void updateToNextGenerataion() {
        int[][] newSpace = new int[SpaceData.height][SpaceData.width];

        //TODO itt kell megírni, hogy előálljon a következő generáció
        for (int j = 1; j < SpaceData.height - 1; j++) {
            for (int i = 1; i < SpaceData.width - 1; i++) {
                int isLiving = space[i][j];
                int neighbours = countNeightbours(i, j);
                if (isLiving == 1 && (neighbours == 2 || neighbours == 3)) {
                    newSpace[i][j] = 1; //eletben marad
                } else if (isLiving == 1) {
                    newSpace[i][j] = 0; //halal
                }

                if (isLiving == 0 && neighbours == 3) {
                    newSpace[i][j] = 1; //ujjaszuletes
                }
            }
        }
        space = newSpace;
    }


    //Ez a függvény megállapítja, hogy egy adott koordinátán élő baktérium van-e,
    // azaz 1-es érték van az adott cellában
    public Boolean isAlive(int y, int x) {
        if (space[y][x] == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int countNeightbours(int width, int height) {
        int result = 0;
        result += space[width][height + 1]; // felso sor
        result += space[width + 1][height + 1]; // felso sor
        result += space[width - 1][height + 1]; // felso sor
        result += space[width - 1][height]; // kozepso sor
        result += space[width + 1][height]; // kozepso sor
        result += space[width][height - 1]; // also sor
        result += space[width + 1][height - 1]; // also sor
        result += space[width - 1][height - 1]; // also sor
        return result;
    }

}
