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
package io.thothbag.inventory.domain.model;


import java.util.Collection;

import io.thothbag.inventory.domain.model.subject.SubjectId;


/**
 * 
 */
public interface SubjectRepository {
    
    /**
     * @param subject new Subject
     */
    void addSubject(Subject subject);
    
    
    /**
     * @return all subject in thothbag inventory
     */
    Collection<Subject> allSubjects();
    
    
    /**
     * @param subjectId
     * @return A subject of specified {@link SubjectId}
     */
    Subject subjectOfId(SubjectId subjectId);
    
}
