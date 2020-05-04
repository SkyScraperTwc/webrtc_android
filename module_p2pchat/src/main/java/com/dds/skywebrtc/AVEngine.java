package com.dds.skywebrtc;

import android.view.View;

import com.dds.skywebrtc.engine.EngineCallback;
import com.dds.skywebrtc.engine.IEngine;

import java.util.List;

public class AVEngine implements IEngine {

    private IEngine iEngine;
    private static volatile AVEngine instance;

    private AVEngine(IEngine engine) {
        iEngine = engine;
    }

    public static AVEngine createEngine(IEngine engine) {
        if (null == instance) {
            synchronized (AVEngine.class) {
                if (null == instance) {
                    instance = new AVEngine(engine);
                }
            }
        }

        return instance;
    }

    @Override
    public void init(EngineCallback callback) {
        if (iEngine == null) {
            return;
        }
        iEngine.init(callback);
    }

    @Override
    public void joinRoom(List<String> userIds) {
        if (iEngine == null) {
            return;
        }
        iEngine.joinRoom(userIds);
    }

    @Override
    public void userIn(String userId) {

    }

    @Override
    public void receiveOffer(String userId, String description) {
        if (iEngine == null) {
            return;
        }
        iEngine.receiveOffer(userId, description);
    }

    @Override
    public void receiveAnswer(String userId, String sdp) {
        if (iEngine == null) {
            return;
        }
        iEngine.receiveAnswer(userId, sdp);
    }

    @Override
    public void receiveIceCandidate(String userId, String id, int label, String candidate) {
        if (iEngine == null) {
            return;
        }
        iEngine.receiveIceCandidate(userId, id, label, candidate);
    }


    @Override
    public void leaveRoom() {
        if (iEngine == null) {
            return;
        }
        iEngine.leaveRoom();
    }

    @Override
    public View startPreview(boolean isO) {
        if (iEngine == null) {
            return null;
        }
        return iEngine.startPreview(isO);
    }

    @Override
    public void stopPreview() {
        if (iEngine == null) {
            return;
        }
        iEngine.stopPreview();
    }

    @Override
    public void startStream() {
        if (iEngine == null) {
            return;
        }
        iEngine.startStream();
    }

    @Override
    public void stopStream() {
        if (iEngine == null) {
            return;
        }
        iEngine.stopStream();
    }

    @Override
    public View setupRemoteVideo(boolean isO) {
        if (iEngine == null) {
            return null;
        }
        return iEngine.setupRemoteVideo(isO);
    }

    @Override
    public void stopRemoteVideo() {
        if (iEngine == null) {
            return;
        }
        iEngine.stopRemoteVideo();
    }

    @Override
    public void release() {

    }

}
