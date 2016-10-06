/*-
 * #%L
 * This file is part of QuPath.
 * %%
 * Copyright (C) 2014 - 2016 The Queen's University of Belfast, Northern Ireland
 * Contact: IP Management (ipmanagement@qub.ac.uk)
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

package qupath.imagej.images.writers;

/**
 * ImageWriter implementation to write zipped TIFF images using ImageJ.
 * 
 * @author Pete Bankhead
 *
 */
public class ZipWriterIJ extends AbstractWriterIJ {

	@Override
	public String getName() {
		return "Zip (ImageJ)";
	}

	@Override
	public String getExtension() {
		return "zip";
	}

	@Override
	public String getDetails() {
		return "Write zipped TIFF file (ImageJ)";
//		return "Write ImageJ zipped TIFF file (optionally including current ROI / overlay)";
	}
	
	@Override
	public boolean supportsRGB() {
		return true;
	}

}
