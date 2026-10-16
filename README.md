# On-Device Fraud Detection SDK

An Android library for detecting behavioral anomalies in mobile payment sessions — designed to prevent authorized push payment (APP) fraud before the transaction is confirmed.

## The Problem

Cloud-based anti-fraud systems analyze transactions after they are initiated. By then, the money has already left the account. For social engineering scams, this is too late. Banks are not obligated to reimburse authorized transfers, and victims bear the loss.

## The Solution

This SDK runs entirely on the user's device. It collects behavioral signals (touch dynamics, navigation patterns, session anomalies) and compares them against a locally stored behavioral profile. If the current session deviates significantly from the user's normal behavior, the SDK triggers an intervention before the payment is confirmed.

No sensitive data leaves the device. No cloud round-trip. Millisecond-level inference.

## Architecture (Planned)

- **Signal Collection Layer** — Android Sensor API, touch event streams, interaction metadata.
- **Feature Extraction** — Lightweight vectorization of behavioral signals.
- **On-Device Model** — TensorFlow Lite / ML Kit custom model for anomaly detection.
- **Intervention API** — Callbacks for UI layer to display warnings or request additional confirmation.
- **Adaptive Update** — Anonymous feedback loop to improve model over time.

## Current Status

This project is in early-stage development. The repository currently contains:
- Basic signal collection module (touch and sensor events)
- Stub for feature extraction pipeline
- Placeholder for on-device inference

## Roadmap

- [ ] Implement behavioral feature extraction
- [ ] Integrate TensorFlow Lite model for anomaly detection
- [ ] Add sample app demonstrating intervention flow
- [ ] Publish benchmark results on synthetic data
- [ ] Release alpha SDK version

## Getting Started

*Instructions will be added as the project evolves.*

## License

MIT
