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


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import io.thothbag.inventory.domain.model.subject.SubjectId;
import io.thothbag.inventory.infrastructure.persistence.InMemorySubjectRepository;


/**
 * Unit test class for {@link SubjectRepository} class.
 * 
 */
public class SubjectRepositoryTest {
    
    /**
     * A {@link SubjectRepository} instance.
     * 
     */
    private SubjectRepository subjectRepository;
    
    
    /**
     * 
     */
    @Before
    public void setUp() {
        this.setSubjectRepository(new InMemorySubjectRepository());
    }
    
    
    /**
     * Test case of {@link SubjectRepository#addSubject(Subject)}.
     * 
     */
    @Test
    public void saveAndFindAllSubjects() {
        final SubjectRepository repository = this.subjectRepository();
        assertThat(repository.allSubjects().size(), is(0));
        
        repository.addSubject(new Subject(repository.nextIdentity()));
        assertThat(this.subjectRepository().allSubjects().size(), is(1));
    }
    
    
    /**
     * Test case of {@link SubjectRepository#subjectOfId(SubjectId)}
     * 
     */
    @Test
    public void saveAndOneSubject() {
        final SubjectId firstId = this.subjectRepository().nextIdentity();
        final SubjectId secondId = this.subjectRepository().nextIdentity();
        assertNull(this.subjectRepository().subjectOfId(firstId));
        assertNull(this.subjectRepository().subjectOfId(secondId));
        
        this.subjectRepository().addSubject(new Subject(firstId));
        assertNotNull(this.subjectRepository().subjectOfId(firstId));
        assertNull(this.subjectRepository().subjectOfId(secondId));
        assertThat(
            this.subjectRepository().subjectOfId(firstId).subjectId(),
            equalTo(firstId));
        
        this.subjectRepository().addSubject(new Subject(secondId));
        assertNotNull(this.subjectRepository().subjectOfId(secondId));
        assertThat(
            this.subjectRepository().subjectOfId(secondId).subjectId(),
            equalTo(secondId));
    }
    
    
    private SubjectRepository subjectRepository() {
        return this.subjectRepository;
    }
    
    
    private void setSubjectRepository(final SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    
}
