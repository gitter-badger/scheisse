/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.dedda.games.scheisse.entity;

/**
 *
 * @author dedda
 */
public interface TestableEntity {

    /**
     * @return lowest id for testing
     */
    public long getMinTestId();

    /**
     * @return highest id for testing
     */
    public long getMaxTestId();
    
}
