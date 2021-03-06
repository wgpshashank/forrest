/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.forrest.core.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

import org.apache.forrest.core.IController;
import org.apache.forrest.core.document.AbstractSourceDocument;
import org.apache.forrest.core.document.DocumentFactory;
import org.apache.forrest.core.exception.SourceException;
import org.apache.forrest.core.locationMap.AbstractSourceNode;
import org.apache.forrest.core.matcher.AbstractMatcher;
import org.apache.log4j.Logger;

/**
 * A File reader reads a resource using the file protocol, i.e. it will read
 * from local storage.
 * 
 */
public class FileReader extends AbstractReader {
	Logger log = Logger.getLogger(FileReader.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.forrest.core.reader.IReader#read(org.apache.forrest.test.core.locationMap.Location)
	 */
	public AbstractSourceDocument read(IController controller, URI requestURI,
			final AbstractSourceNode sourceNode, AbstractMatcher matcher) {
		AbstractSourceDocument result = null;
		try {
			URL resolvedURL = sourceNode.resolveURL(matcher, requestURI);
			final InputStream is = new FileInputStream(new File(resolvedURL.toURI()));
			result = DocumentFactory.getSourceDocumentFor(resolvedURL, requestURI, is);
			if (result == null) {
				log.debug("No source document exists at " + resolvedURL.toExternalForm());
			} else {
				log.debug("Read a source document from " + resolvedURL.toExternalForm());
			}
		} catch (final Exception e) {
			String msg = "Unable to resolve the source URL";
			log.debug(msg + ": " + e.getMessage());
			if (sourceNode.isRequired())
				throw new SourceException(msg, e);
		}
		return result;
	}
}
