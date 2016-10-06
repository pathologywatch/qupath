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

package qupath.lib.gui.viewer.recording;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.text.DecimalFormat;

/**
 * Data relating to a single recording frame.
 * 
 * TODO: This has hung on from Swing days with a lot of AWT.  Should be updated...
 * 
 * @author Pete Bankhead
 * 
 */
public class ViewRecordingFrame {
	
	private static DecimalFormat df = new DecimalFormat("#.##");
	
	private long timestamp;
	private Shape region; // Store vertices 
	private Dimension canvasSize;
	private Point2D cursorPosition, eyePosition;
	private Boolean isFixated;
	
//	public RecordingFrame(long timestamp, Rectangle imageBounds, Dimension canvasSize) {
//		this(timestamp, imageBounds, canvasSize);
//	}
	
	public ViewRecordingFrame(long timestamp, Shape region, Dimension canvasSize) {
		this(timestamp, region, canvasSize, null);
	}
	
	public ViewRecordingFrame(long timestamp, Shape region, Dimension canvasSize, Point2D cursorPosition) {
		this(timestamp, region, canvasSize, cursorPosition, null, false);
	}
	
	public ViewRecordingFrame(long timestamp, Shape region, Dimension canvasSize, Point2D cursorPosition, Point2D eyePosition, Boolean isFixated) {
		this.timestamp = timestamp;
		this.canvasSize = canvasSize;
		this.region = region;
		this.cursorPosition = cursorPosition;
		this.eyePosition = eyePosition;
		this.isFixated = isFixated;
	}
	
	
	@Override
	public String toString() {
		String s = String.format("Timestamp: %d, Shape: %s, Canvas size: %d, %d", timestamp, region.toString(), canvasSize.width, canvasSize.height);
		if (cursorPosition != null)
			s += ", Cursor position: " + df.format(cursorPosition.getX()) + ", " + df.format(cursorPosition.getY());
		if (eyePosition != null)
			s += ", Eye position: " + df.format(eyePosition.getX()) + ", " + df.format(eyePosition.getY()) + ", Is fixated: " + isFixated;
		return s;
	}
	
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public Rectangle getImageBounds() {
		return region.getBounds();
	}
	
	public Point2D getCursorPosition() {
		return cursorPosition == null ? null : new Point2D.Double(cursorPosition.getX(), cursorPosition.getY());
	}

	public boolean hasCursorPosition() {
		return cursorPosition != null;
	}
	
	public Point2D getEyePosition() {
		return eyePosition == null ? null : new Point2D.Double(eyePosition.getX(), eyePosition.getY());
	}
	
	/**
	 * Boolean.TRUE if the eye tracking information suggests the eye is fixated, Boolean.FALSE if not, and null if no information is available.
	 * @return
	 */
	public Boolean isEyeFixated() {
		return isFixated;
	}

	public boolean hasEyePosition() {
		return eyePosition != null;
	}
	
	public Shape getImageShape() {
		if (region instanceof Rectangle2D)
			return (Shape)((Rectangle2D)region).clone();
		return new Path2D.Double(region);
	}
	
	public Dimension getSize() {
		return canvasSize;
	}
	
}