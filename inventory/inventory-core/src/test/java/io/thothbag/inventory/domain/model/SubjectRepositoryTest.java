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
        SubjectRepository repository = this.subjectRepository();
        assertThat(repository.allSubjects().size(), is(0));
        
        Subject subject = new Subject(new SubjectId("subject_id"));
        repository.addSubject(subject);
        assertThat(this.subjectRepository().allSubjects().size(), is(1));
    }
    
    
    /**
     * Test case of {@link SubjectRepository#subjectOfId(SubjectId)}
     * 
     */
    @Test
    public void saveAndOneSubject() {
        assertNull(this.subjectRepository.subjectOfId(new SubjectId("subject_id1")));
        
        Subject fixture1 = new Subject(new SubjectId("subject_id1"));
        this.subjectRepository().addSubject(fixture1);
        assertNotNull(this.subjectRepository().subjectOfId(new SubjectId("subject_id1")));
        assertNull(this.subjectRepository().subjectOfId(new SubjectId("subject_id2")));
        assertThat(
            this.subjectRepository().subjectOfId(new SubjectId("subject_id1")).subjectId(),
            equalTo(fixture1.subjectId()));
        
        Subject fixture2 = new Subject(new SubjectId("subject_id2"));
        this.subjectRepository().addSubject(fixture2);
        assertNotNull(this.subjectRepository().subjectOfId(new SubjectId("subject_id2")));
        assertThat(
            this.subjectRepository().subjectOfId(new SubjectId("subject_id2")).subjectId(),
            equalTo(fixture2));
    }
    
    
    private SubjectRepository subjectRepository() {
        return this.subjectRepository;
    }
    
    
    private void setSubjectRepository(final SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }
    
}
