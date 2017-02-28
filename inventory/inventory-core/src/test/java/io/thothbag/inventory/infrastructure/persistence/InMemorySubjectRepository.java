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
package io.thothbag.inventory.infrastructure.persistence;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import io.thothbag.inventory.domain.model.Subject;
import io.thothbag.inventory.domain.model.SubjectRepository;
import io.thothbag.inventory.domain.model.subject.SubjectId;


/**
 * 
 */
public class InMemorySubjectRepository implements SubjectRepository {
    
    private final Map<SubjectId, Subject> storage;
    
    
    /**
     * 
     */
    public InMemorySubjectRepository() {
        this.storage = new HashMap<>();
    }
    
    
    /**
     * @see io.thothbag.inventory.domain.model.SubjectRepository#addSubject(io.thothbag.inventory.domain.model.Subject)
     */
    @Override
    public void addSubject(Subject subject) {
        this.storage.put(subject.subjectId(), subject);
    }
    
    
    /**
     * @see io.thothbag.inventory.domain.model.SubjectRepository#allSubjects()
     */
    @Override
    public Collection<Subject> allSubjects() {
        return this.storage.values();
    }
    
    
    /**
     * @see io.thothbag.inventory.domain.model.SubjectRepository#subjectOfId(io.thothbag.inventory.domain.model.subject.SubjectId)
     */
    @Override
    public Subject subjectOfId(SubjectId subjectId) {
        return this.repository().get(subjectId);
    }
    
    
    private Map<SubjectId, Subject> repository() {
        return this.storage;
    }
    
}
