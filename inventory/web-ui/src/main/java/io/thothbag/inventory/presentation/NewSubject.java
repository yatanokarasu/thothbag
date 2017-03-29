/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2017 Yusuke TAKEI.
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */
package io.thothbag.inventory.presentation;


import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;


/**
 *
 */
@ManagedBean
public class NewSubject {

    private static final Map<String, Integer> DISCLOSURES;

    private int                               border;

    private String                            description;

    private String                            name;

    private String                            testingTime;

    private int                               disclosureCode;


    static {
        final Map<String, Integer> map = new LinkedHashMap<>(2);
        map.put("公開", 1);
        map.put("非公開", 2);

        DISCLOSURES = Collections.unmodifiableMap(map);
    }


    /**
     * @return the border
     */
    public final int getBorder() {
        return this.border;
    }


    /**
     * @return the description
     */
    public final String getDescription() {
        return this.description;
    }


    /**
     * @return disclosures
     */
    public final Map<String, Integer> getDisclosures() {
        return DISCLOSURES;
    }


    /**
     * @return the name
     */
    public final String getName() {
        return this.name;
    }


    /**
     * @return the testingTime
     */
    public final String getTestingTime() {
        return this.testingTime;
    }


    /**
     * @param border the border to set
     */
    public final void setBorder(final int border) {
        this.border = border;
    }


    /**
     * @param description the description to set
     */
    public final void setDescription(final String description) {
        this.description = description;
    }


    /**
     * @param name the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }


    /**
     * @param testingTime the testingTime to set
     */
    public final void setTestingTime(final String testingTime) {
        this.testingTime = testingTime;
    }


    /**
     * @return the disclosureCode
     */
    public int getDisclosureCode() {
        return disclosureCode;
    }


    /**
     * @param disclosureCode the disclosureCode to set
     */
    public void setDisclosureCode(final int disclosureCode) {
        this.disclosureCode = disclosureCode;
    }

}
