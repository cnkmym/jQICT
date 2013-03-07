package jp.co.worksap.ate.jpict.testutil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import jp.co.worksap.ate.jpict.core.Parameter;
import jp.co.worksap.ate.jpict.core.ParameterList;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class ParameterFileReader {
        private FileReader fs;
        private BufferedReader sr;

        public ParameterFileReader() {
                super();
        }

        public ParameterList getParameterList(String file)
                        throws JsonSyntaxException, IOException {
                fs = new FileReader(file);
                sr = new BufferedReader(fs);

                String line = null;
                Gson gson = new Gson();

                List<Parameter> parameters = new ArrayList<Parameter>();

                while ((line = sr.readLine()) != null) {
                        Parameter parameter = gson.fromJson(line,
                                        Parameter.class);
                        if (parameter != null) {
                                parameters.add(parameter);
                        }
                } // while

                silentClose(sr);
                silentClose(fs);

                return new ParameterList(parameters);
        }

        private void silentClose(Reader r) {
                if (r != null) {
                        try {
                                r.close();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
        }
}
