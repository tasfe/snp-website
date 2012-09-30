/*
 * Copyright 2004 Carlos Sanchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sunrise.sup.core.common.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Concat lists in a new one
 * 
 * @author Carlos Sanchez
 * @version $Revision: 1.1 $
 */
public class ListConcatenator extends ArrayList {

	public ListConcatenator(List list) {
		super();
		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			List element = (List) iter.next();
			addAll(element);
		}
	}

}