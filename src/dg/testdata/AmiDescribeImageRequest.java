package dg.testdata;

import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.model.DescribeImagesRequest;
import com.amazonaws.services.ec2.model.DescribeImagesResult;

public class AmiDescribeImageRequest {
    public void missingOwnerNoFilter(final AmazonEC2 client) {
        DescribeImagesResult result =
            client.describeImages(new DescribeImagesRequest());
    }
}
