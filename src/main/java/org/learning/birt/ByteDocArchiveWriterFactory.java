package org.learning.birt;
import org.eclipse.birt.report.engine.api.IDocArchiveWriter;
import org.eclipse.birt.report.engine.api.IDocArchiveWriterAccess;
import org.eclipse.birt.report.engine.api.IDocArchiveWriterFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteDocArchiveWriterFactory implements IDocArchiveWriterFactory {
    @Override
    public IDocArchiveWriterAccess openArchiveWriter(final String archiveFile)
            throws IOException {
        return new IDocArchiveWriterAccess() {
            private RAOutputStream outputStream;

            @Override
            public void close() throws IOException {
                if (outputStream != null) {
                    outputStream.close();
                    outputStream = null;
                }
            }

            @Override
            public OutputStream getOutputStream(String fileName)
                    throws IOException {
                if (outputStream != null) {
                    throw new IOException("Output stream already acquired");
                }
                outputStream = new RAOutputStream();
                return outputStream;
            }

            @Override
            public void writeFile(String fileName, InputStream input)
                    throws IOException {
                if (outputStream == null) {
                    throw new IOException("Output stream not acquired");
                }
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
            }
        };
    }

    private class RAInputStream extends InputStream {
        private byte[] data;
        private int position;

        public RAInputStream(byte[] data) {
            this.data = data;
            this.position = 0;
        }

        @Override
        public int read() throws IOException {
            if (position >= data.length) {
                return -1;
            }
            return data[position++];
        }
    }

    private class RAOutputStream extends OutputStream {
        private byte[] data;
        private int position;

        public RAOutputStream() {
            this.data = new byte[1024];
            this.position = 0;
        }

        @Override
        public void write(int b) throws IOException {
            if (position >= data.length) {
                // Extend the array if necessary
                byte[] newData = new byte[data.length * 2];
                System.arraycopy(data, 0, newData, 0, data.length);
                data = newData;
            }
            data[position++] = (byte) b;
        }

        @Override
        public void write(byte[] b) throws IOException {
            write(b, 0, b.length);
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            if (position + len > data.length) {
                // Extend the array if necessary
                int newSize = Math.max(data.length * 2, position + len);
                byte[] newData = new byte[newSize];
                System.arraycopy(data, 0, newData, 0, data.length);
                data = newData;
            }
            System.arraycopy(b, off, data, position, len);
            position += len;
        }

        @Override
        public void close() throws IOException {
            // Optional: Perform any necessary cleanup or finalization
        }
    }
}
