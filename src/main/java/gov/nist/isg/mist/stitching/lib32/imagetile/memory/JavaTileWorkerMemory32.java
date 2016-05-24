// Disclaimer: IMPORTANT: This software was developed at the National
// Institute of Standards and Technology by employees of the Federal
// Government in the course of their official duties. Pursuant to
// title 17 Section 105 of the United States Code this software is not
// subject to copyright protection and is in the public domain. This
// is an experimental system. NIST assumes no responsibility
// whatsoever for its use by other parties, and makes no guarantees,
// expressed or implied, about its quality, reliability, or any other
// characteristic. We would appreciate acknowledgement if the software
// is used. This software can be redistributed and/or modified freely
// provided that any derivative works bear some notice that they are
// derived from it, and any modified versions bear some notice that
// they have been modified.


// ================================================================
//
// Author: tjb3
// Date: May 16, 2014 3:52:20 PM EST
//
// Time-stamp: <May 16, 2014 3:52:20 PM tjb3>
//
//
// ================================================================

package gov.nist.isg.mist.stitching.lib32.imagetile.memory;

import org.bridj.Pointer;

import java.nio.ByteBuffer;

import gov.nist.isg.mist.stitching.lib.imagetile.ImageTile;
import gov.nist.isg.mist.stitching.lib.imagetile.memory.TileWorkerMemory;
import gov.nist.isg.mist.stitching.lib32.imagetile.java.JavaImageTile32;
import jcuda.driver.CUdeviceptr;

/**
 * Represents memory that a Java Tile will be working with
 *
 * @author Tim Blattner
 * @version 1.0
 */
public class JavaTileWorkerMemory32 extends TileWorkerMemory {

  private float[][] arrayMemory;

  /**
   * Initializes the Java tile worker memory
   *
   * @param initTile the initial tile
   */
  public JavaTileWorkerMemory32(ImageTile<?> initTile) {
    super(initTile.getWidth(), initTile.getHeight());

    int fftWidth = JavaImageTile32.fftPlan.getFrequencySampling1().getCount() * 2;
    int fftHeight = JavaImageTile32.fftPlan.getFrequencySampling2().getCount();
    this.arrayMemory = new float[fftHeight][fftWidth];
  }

  @Override
  public float[][] getArrayMemory() {
    return this.arrayMemory;
  }

  @Override
  public void releaseMemory() {
    this.arrayMemory = null;
  }

  @Override
  public ByteBuffer getImageBuffer() {
    throw new IllegalStateException("getImageBuffer is only used for JCUDA Tile workers");
  }

  @Override
  public ByteBuffer getIndexBuffer() {
    throw new IllegalStateException("getIndexBuffer is only used for JCUDA Tile workers");
  }

  @Override
  public ByteBuffer getFilterBuffer() {
    throw new IllegalStateException("getFilterBuffer is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getFftIn() {
    throw new IllegalStateException("getFftIn is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getPcmIn() {
    throw new IllegalStateException("getPcmIn is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getPcm() {
    throw new IllegalStateException("getPcm is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getMaxOut() {
    throw new IllegalStateException("getMaxOut is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getMultiMaxOut() {
    throw new IllegalStateException("getMultiMaxOut is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getMultiIdxOut() {
    throw new IllegalStateException("getMultiIdxOut is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getIdxOut() {
    throw new IllegalStateException("getIdxOut is only used for JCUDA Tile workers");
  }

  @Override
  public CUdeviceptr getIdxFilter() {
    throw new IllegalStateException("getIdxFilter is only used for JCUDA Tile workers");
  }

  @Override
  public Integer[] getIndices() {
    throw new IllegalStateException("getIndices is only used for JCUDA Tile workers");
  }

  @Override
  public Pointer<Float> getPCMPMemory() {
    throw new IllegalStateException("getPCMPMemory is only used for FFTW Tile workers");
  }

  @Override
  public Pointer<Float> getPCMInMemory() {
    throw new IllegalStateException("getPCMInMemory is only used for FFTW Tile workers");
  }

  @Override
  public Pointer<Float> getFFTInP() {
    throw new IllegalStateException("getFFTInP is only used for FFTW Tile workers");
  }


  @Override
  public Pointer<Integer> getPeaks() {
    throw new IllegalStateException("getPeaks is only used for FFTW Tile workers");
  }


}
