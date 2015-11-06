import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aman on 05-11-2015.
 */
public class NeuralNetwork {

    private int numInput;
    private int numHidden;
    private int numOutput;
    private List<Double> inputs;
    private List<List<Double>> ihWeights;
    private List<Double> hBiases;
    private List<Double> hOutputs;
    private List<List<Double>> hoWeights;
    private List<Double> oBiases;
    private List<Double> outputs;
    private List<Double> oGrads;
    private List<Double> hGrads;
    private List<List<Double>> ihPrevWeightsDelta;
    private List<Double> hPrevBiasesDelta;
    private List<List<Double>> hoPrevWeightsDelta;
    private List<Double> oPrevBiasesDelta;

    public NeuralNetwork(int numInput, int numHidden, int numOutput) {
        this.numInput = numInput;
        this.numHidden = numHidden;
        this.numOutput = numOutput;
    }

    public void setWeights(List<Double> weights) {
        int k = 0;

        for (int i = 0; i < numInput; i++) {
            List<Double> ihWeightsRow = new ArrayList<>();
            for (int j = 0; j < numHidden; j++) {
                ihWeightsRow.add(weights.get(k++));
            }
            ihWeights.add(ihWeightsRow);
        }

        for (int i = 0; i < numHidden; i++) {
            hBiases.add(weights.get(k++));
        }

        for (int i = 0; i < numHidden; i++) {
            List<Double> hoWeightsRow = new ArrayList<>();
            for (int j = 0; j < numOutput; j++) {
                hoWeightsRow.add(weights.get(k++));
            }
            hoWeights.add(hoWeightsRow);
        }

        for (int i = 0; i < numOutput; i++) {
            oBiases.add(weights.get(k++));
        }
    }

    public List<Double> getWeights() {
        int numWeights = (this.numInput * this.numHidden) +
                this.numHidden +
                (this.numHidden * this.numOutput) +
                this.numOutput;

        List<Double> result = new ArrayList<>();

        int k = 0;

        for (int i = 0; i < numInput; i++) {
            for (int j = 0; j < numHidden; j++) {
                result.add(ihWeights.get(i).get(j));
            }
        }

        for (int i = 0; i < numHidden; i++) {
            result.add(hBiases.get(i));
        }

        for (int i = 0; i < numHidden; i++) {
            for (int j = 0; j < numOutput; j++) {
                result.add(hoWeights.get(i).get(j));
            }
        }

        for (int i = 0; i < numOutput; i++) {
            result.add(oBiases.get(i));
        }

        return result;
    }
}
